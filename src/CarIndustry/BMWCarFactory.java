package CarIndustry;

import java.util.Arrays;
import java.util.Calendar;

public class BMWCarFactory {

    private final ModelList[] model;
    private final EngineCapacityList[] engineCapacity;

    private ColorList[] color;
    private WheelSizeList[] wheelSize;
    private final BMWCarStorage myBMWCarStorage;
    private final CarService BMWCarService;

    public BMWCarFactory(ModelList[] model, EngineCapacityList[] engineCapacity, ColorList[] color,
                         WheelSizeList[] wheelSize, CarService BMWCarService) {
        this.model = model;
        this.engineCapacity = engineCapacity;
        this.color = color;
        this.wheelSize = wheelSize;
        this.myBMWCarStorage = new BMWCarStorage(); // создаем склад для звода
        this.BMWCarService = new CarService(); // и сервис
        // добавляем машиныы на склад (пусть на складе 10 мест)

        int placesInTheStorage = 10;
        Car BMWCar;
        for (int j = 0; j < placesInTheStorage; j++) {
            BMWCar = new Car(model, Calendar.getInstance().get(Calendar.YEAR),  engineCapacity, color, wheelSize);
            this.myBMWCarStorage.addCarInBMWStorage(BMWCar);

        }
    }


    // вывод на печать возможных для производства цветов/объемов двигателей/ моделей/ размеров колес
    public void printCarFactoryOpportunities() {
        System.out.println("На нашем автозаводе выпускаются автомобили со следующими характеристиками: ");
        System.out.println("модели: " + Arrays.toString(model));
        System.out.println("цвета: " + Arrays.toString(color));
        System.out.println("Объем двигателя: " + Arrays.toString(engineCapacity));
        System.out.println("размер колес: " + Arrays.toString(wheelSize));
    }
    //создать автомобиль по заказу солона

    private void createCar(ModelList model, Integer manufactureYear, EngineCapacityList engineCapacity,
                           ColorList color, WheelSizeList wheelSize) {
        BMWCarStorage.addCarInBMWStorage (new Car(model, Calendar.getInstance().get(Calendar.YEAR),
                engineCapacity, color, wheelSize));
    }

    // проверяем можно ли создать машину с заданными параметрами на заводе используя флаг как в задаче с треуг.матрицей

    private boolean checkCarParameters(ModelList model, Integer manufactureYear, EngineCapacityList engineCapacity,
                                       ColorList color, WheelSizeList wheelSize) {
        boolean flag = false;

        for (ModelList existent : this.model) { // модель
            if (existent.equals(model)) {
                flag = true;
                break;
            } else {
                return flag;
            }
        }
        for (EngineCapacityList existent : this.engineCapacity) { // объем двигателя
            if (existent.equals(engineCapacity)) {
                flag = true;
                break;
            } else {
                return flag;
            }
        }
        for (ColorList existent : this.color) { // цвет
            if (existent.equals(color)) {
                flag = true;
                break;
            } else {
                return flag;
            }
        }
        for (WheelSizeList existent : this.wheelSize) { //размер колес
            if (existent.equals(wheelSize)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

// выполняем требования автодилера - ищим на складе подходящую, если есть с частичным совпадением - передаем в сервис,
   // если подходящей машины нет, то создаем новую
    public Car BMWDilershipRequirement(ModelList model, EngineCapacityList engineCapacity, ColorList color,
                                       WheelSizeList wheelSize, CarAccessories... additionalAccessories) {
        if (checkCarParameters(model, engineCapacity, color, wheelSize)) {
            int placeInTheStorage = BMWCarStorage.searchCarInTheStorage (model, engineCapacity, color, wheelSize);
            if (placeInTheStorage > 0) {
                System.out.println("Машина с заданными параметрами найдена и находится в гараже на месте " + placeInTheStorage);
                return BMWCarStorage.RelocateCarFromStorage (placeInTheStorage);
            }
            placeInTheStorage = BMWCarStorage.searchCarInTheStorage(model, engineCapacity);
            if (placeInTheStorage > 0) {
                System.out.println("Найден автомобиль на складе автопроизводителя, частично удовлетворяющая параметрам. " +
                        "Машина отправляется в автосервис для изменения параметров в соответствии с заказом автодилера");
                CarService carService = new CarService();
                carService.changeColor(BMWCarStorage.getBMWCarStorage()[placeInTheStorage], color);
                carService.changeWheelSize(BMWCarStorage.getBMWCarStorage()[placeInTheStorage], wheelSize);
                return BMWCarStorage.RelocateCarFromStorage(placeInTheStorage);
            }
            System.out.println("Так как автобомиль с заданными параметрами не найден на складе, мы создадим для Вас новый!");
            createCar(model, engineCapacity, color, wheelSize);
            if (additionalAccessories.length > 0) {
                for (int i = 0; i < additionalAccessories.length; i++) {
                    (BMWCarStorage.getBMWCarStorage()[BMWCarStorage.getBMWCarStorage().length - 1],
                            additionalAccessories[i]);
                }
            }
            return BMWCarStorage.RelocateCarFromStorage (BMWCarStorage.length - 1);
        } else {
            System.out.println("Наш автозавод не может создать автомобиль с запрашиваемыми параметрами.");
        }
        return null;
    }
}

