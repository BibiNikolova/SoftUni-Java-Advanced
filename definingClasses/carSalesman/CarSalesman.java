package objectsAndClasses.carSalesman;

public class CarSalesman {
    static class Engine{
        String engineModel;
        int power;
        String displacement;//optional
        String efficiency;//optional

        public Engine(String engineModel, int power, String displacement, String efficiency) {
            this.engineModel = engineModel;
            this.power = power;
            this.displacement = displacement;
            this.efficiency = efficiency;

        }
        public String getEngineModel() {
            return this.engineModel;
        }
        @Override
        public String toString() {
            return String.format("  %s:\n    Power: %d\n    Displacement: %s\n    Efficiency: %s",
                    this.engineModel, this.power, this.displacement, this.efficiency);
        }
    }
    static class Car{
        String model;
        String engineModel;
        String weight;//optional
        String colour;//optional

        public Car(String model, String engineModel, String weight, String colour) {
            this.model = model;
            this.engineModel = engineModel;
            this.weight = weight;
            this.colour = colour;
        }

        public String getEngineModel() {
            return this.engineModel;
        }

        public String getWeight() {
            return this.weight;
        }

        public String getColour() {
            return this.colour;
        }

        public String getModel() {
            return this.model;
        }

        @Override
        public String toString() {
            return String.format("  Weight: %s%n  Color: %s", this.weight, this.colour);
        }
    }
}
