package definingClasses.rawData;

public class RawData {

    static class Car {
        String model;
        int enginePower;
        String cargoType;
        double tyrePressure;

        Car(String model, int enginePower, String cargoType,
                   double tyrePressure) {
            this.model = model;
            this.enginePower = enginePower;
            this.cargoType = cargoType;
            this.tyrePressure = tyrePressure;
        }

        @Override
        public String toString() {
            return String.format("%s", this.model);
        }

        public String getCargoType() {
            return this.cargoType;
        }

        public int getEnginePower() {
            return this.enginePower;
        }

        public double getTyrePressure() {
            return this.tyrePressure;
        }
    }
}

