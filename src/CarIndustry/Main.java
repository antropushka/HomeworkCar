package CarIndustry;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        BMWCarFactory BMWfactory = new BMWCarFactory();

        BMWCarFactory.printCarFactoryOpportunities();

        CarService BMWCarService = new CarService();

        BMWCarDealership dealership = new BMWCarDealership(BMWCarFactory, BMWCarService);

        Car oneDilershipOrder = new Car(ModelList.BMWXX7, 2019, EngineCapacityList.V5_0 ,
                ColorList.BLACK, WheelSizeList.WHEEL_8_5Jx20ET35, CarAccessories.ROOF_RACK);
        oneDilershipOrder = dealership.addCarAccessories(oneDilershipOrder, CarAccessories.ACCENT_STRIPES);

        Car twoDilershipOrder  = dealership.BMWDilershipOrder(ModelList.BMWXX4, WheelSizeList.WHEEL_8Jx19ET47,
                ColorList.YELLOW, 18, CarAccessories.NAVIGATION_SYSTEM);
        System.out.println(twoDilershipOrder);

        Car threeDilershipOrder  = new Car(ModelList.BMWXGRANCOPE, 2022, EngineCapacityList.V2_0,
                ColorList.GREY, WheelSizeList.WHEEL_10_5Jx22ET43, CarAccessories.LEATHER_SEATS, CarAccessories.HEATED_SEATS);
        dealership.changeCarParameter(threeDilershipOrder, WheelSizeList.WHEEL_7_5Jx17ET52);

    }
}
