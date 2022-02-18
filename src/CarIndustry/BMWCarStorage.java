package CarIndustry;

public class BMWCarStorage {
    private Car[] BMWCarStorage;

    public BMWCarStorage() {
        this.BMWCarStorage = new Car[10];
    }

    public Car[] getBMWCarStorage() {
        return BMWCarStorage;
    }


    // поис машины по полному совпадению параметров, чтобы выполнить заказ
    public Integer searchCarInTheStorage (ModelList model, Integer manufactureYear, EngineCapacityList engineCapacity,
                              ColorList color, WheelSizeList wheelSize) {
        for (int i = 0; i < BMWCarStorage.length; i++) {
            if (BMWCarStorage[i].getModel().equals(model) && BMWCarStorage[i].getManufactureYear().equals(manufactureYear)
                    && BMWCarStorage[i].getEngineCapacity().equals(engineCapacity)
                    && BMWCarStorage[i].getColor().equals(color) && BMWCarStorage[i].getWheelSize().equals(wheelSize)) {
                return i;
            }
        }
        return -1;
    }
    // поис машины по  совпадению параметров МОДЕЛЬ,ОБЪЕМ ДВИГАТЕЛЯ (кот-е неизменяемые), чтобы  отправить в сервис
    public Integer searchCarInTheStorage (ModelList model, EngineCapacityList engineCapacity) {
        for (int i = 0; i < BMWCarStorage.length; i++) {
            if (BMWCarStorage[i].getModel().equals(model)  &&
                    BMWCarStorage[i].getEngineCapacity().equals(engineCapacity)) {
                return i;
            }
        }
        return -1;
    }
    //     Добавить созданную машину в гараж
    public  void addCarInBMWStorage (Car BMWCar) {
        Car[] arrayStorageDest = new Car[BMWCarStorage.length + 1];
        System.arraycopy(BMWCarStorage, 0, arrayStorageDest, 0,BMWCarStorage.length);
        arrayStorageDest [arrayStorageDest.length - 1] = BMWCar;
        this.BMWCarStorage = arrayStorageDest;
    }

    public Car RelocateCarFromStorage (Integer placeInStorage) {
        Car[] arrayStorageDest = new Car[BMWCarStorage.length - 1];
        if (placeInStorage > 0) {
            System.arraycopy(BMWCarStorage, 0, arrayStorageDest, 0, placeInStorage);
        }
        System.arraycopy(BMWCarStorage, placeInStorage + 1, arrayStorageDest, placeInStorage,
                arrayStorageDest.length - placeInStorage);
        Car CarDest = BMWCarStorage[placeInStorage];
        this.BMWCarStorage = arrayStorageDest;
        return CarDest;
    }
}

