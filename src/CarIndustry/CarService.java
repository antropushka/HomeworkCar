package CarIndustry;

public class CarService {

   // меняем цвет
    public void changeColor(Car BMWCar, ColorList color) {
        if (BMWCar.getColor().equals(color)) {
            System.out.println( "цвет машины соответствует цвету, указанному в заказе.");
            return;
        }
        BMWCar.setColor(color);
        System.out.println("Машина перекрашена в " + color.name());
    }
    // меняем колеса
    public void changeWheelSize(Car BMWcar, WheelSizeList wheelSize) {
        if (BMWcar.getWheelSize().equals(wheelSize)) {
            System.out.println("Текущий размер колес соответствует размеру, указанному в заказе.");
            return;
        }
        BMWcar.setWheelSize(wheelSize);
        System.out.println("Колеса заменены на "  + wheelSize.name() + " размер.");
    }
    // добавляем доп опции
    public void addCarAccessories (Car BMWcar, CarAccessories additionalAccessories) {
        for (CarAccessories existent : BMWcar.getAdditionalAccessories()) {
            if (existent.equals(additionalAccessories)) {
                System.out.println("Машина содержит указанную опцию");
                return;
            }
        }
       CarAccessories ArrayCarAccessoriesDest = new CarAccessories [BMWcar.getAdditionalAccessories().length + 1];
        System.arraycopy(BMWcar.getAdditionalAccessories(), 0, ArrayCarAccessoriesDest,
                0, BMWcar.getAdditionalAccessories().length);
        ArrayCarAccessoriesDest[ArrayCarAccessoriesDest.length - 1] = CarAccessories;
        BMWcar.setAdditionalAccessories(ArrayCarAccessoriesDest);
        System.out.println("Опция " + additionalAccessories.name() + " добавлена на автомобиль.");
    }

    // удаляем доп опции
    public void deleteCarAccessories (Car BMWcar, CarAccessories additionalAccessories) {
        for (int i = 0; i < BMWcar.getAdditionalAccessories().length; i++) {
            if (BMWcar.getAdditionalAccessories()[i].equals(additionalAccessories)) {
                CarAccessories ArrayCarAccessoriesDest = new CarAccessories[BMWcar.getAdditionalAccessories().length - 1];
                if (i > 0) {
                    System.arraycopy(BMWcar.getAdditionalAccessories(), 0, ArrayCarAccessoriesDest, 0, i);
                }
                System.arraycopy(BMWcar.getAdditionalAccessories(), i + 1, ArrayCarAccessoriesDest, i, ArrayCarAccessoriesDest.length - i);
                BMWcar.setAdditionalAccessories(ArrayCarAccessoriesDest);
                System.out.println("опция(" + additionalAccessories.name() + ") удалена");
                return;
            }
        }
        System.out.println("Данная опция не может быть применена к Вашему автомобилю");
    }
}
