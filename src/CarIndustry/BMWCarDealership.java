package CarIndustry;

public class BMWCarDealership {

    private final BMWCarFactory BMWfactory;
    private final CarService BMWService;


    public  BMWCarDealership(BMWCarFactory BMWfactory, CarService BMWService) { // создают заказ, меняют под соответствие
        this.BMWfactory = BMWfactory;
        this.BMWService = BMWService;

    }

    // создаем отдельно каждый метод для изменяемых параметров, делаеем перегрузку (основной метод change находится
    // в сервис, т.е. добавляем в метод вывоз сервиса.change нужный параметр) - принимает машину и параметр,
    // возращает измененную машину

    public Car changeCarParameter(Car BMWCar, ColorList color) {
        BMWService.changeColor(BMWCar, color);
        return BMWCar;
    }

    public Car changeCarParameter(Car BMWCar, WheelSizeList wheelSize) {
        BMWService.changeWheelSize(BMWCar, wheelSize);
        return BMWCar;
    }

    public Car changeCarParameter(Car BMWCar, ColorList сolor, WheelSizeList wheelSize) { // если не совпало 2 параметра, меняем их
        BMWService.changeColor(BMWCar, сolor);
        BMWService.changeWheelSize(BMWCar, wheelSize);
        return BMWCar;
    }

    // создаем методы для удаления и добавления доп. опций (метод от car(??) потому что возвращает car))

    public Car addCarAccessories (Car BMWCar, CarAccessories... additionalAccessories) {
        if (additionalAccessories.length > 0) {
            for (int i = 0; i < additionalAccessories.length; i++) {
                BMWService.addCarAccessories(BMWCar, additionalAccessories[i]);
            }
        }
        return BMWCar;
    }

    public Car deleteCarAccessories (Car BMWCar, CarAccessories... additionalAccessories) {
        if (additionalAccessories.length > 0) {
            for (int i = 0; i < additionalAccessories.length; i++) {
                BMWService.addCarAccessories(BMWCar, additionalAccessories[i]);
            }
        }
        return BMWCar;
    }

    // метод для создания заказа на автомобиль на завод
    public Car BMWDilershipOrder (ModelList model, EngineCapacityList engineCapacity, ColorList color,
                           WheelSizeList wheelSize, CarAccessories... additionalAccessories) {
        return BMWfactory.BMWDilershipRequirement(model, engineCapacity, color, wheelSize, additionalAccessories);
    }
}

