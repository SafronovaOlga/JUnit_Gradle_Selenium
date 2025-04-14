package safronova;

import java.text.DecimalFormat;

import static safronova.DeliveryD.MINIMUM_DELIVERY_AMOUNT;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main{
        
        public static void main(String[] args) {
            // Пример вызова функции
            double distance = 25; // Расстояние в км
            String size = "большие"; // Габариты груза
            boolean isFragile = true; // Хрупкость груза
            String workload = "высокая"; // Загруженность службы доставки
            
            double cost = calculateDeliveryCost(distance, size, isFragile, workload);
            System.out.println("Стоимость доставки: " + cost + " рублей");
            // Стоимость доставки: 980.0 рублей
        }
        
        public static double calculateDeliveryCost(double distance, String size, boolean isFragile, String workload) {
            double baseCost = 0;
            
            // Расчет стоимости в зависимости от расстояния
            if (distance > 30) {
                baseCost += 300;
            } else if (distance > 10) {
                baseCost += 200;
            } else if (distance > 2) {
                baseCost += 100;
            } else {
                baseCost += 50;
            }
            
            // Проверка на хрупкость и расстояние
            if (isFragile && distance > 30) {
                throw new IllegalArgumentException("Хрупкие грузы нельзя возить на расстояние более 30 км");
            }
            
            // Расчет стоимости в зависимости от габаритов
            if (size.equals("большие")) {
                baseCost += 200;
            } else if (size.equals("маленькие")) {
                baseCost += 100;
            }
            
            // Добавление стоимости за хрупкость
            if (isFragile) {
                baseCost += 300;
            }
            
            // Применение коэффициента загруженности
            double workloadCoefficient = 1.0;
            switch (workload) {
                case "очень высокая":
                    workloadCoefficient = 1.6;
                    break;
                case "высокая":
                    workloadCoefficient = 1.4;
                    break;
                case "повышенная":
                    workloadCoefficient = 1.2;
                    break;
                default:
                    workloadCoefficient = 1.0;
            }
            
            double totalCost = baseCost * workloadCoefficient;
            
            // Проверка на минимальную стоимость доставки
            if (totalCost < 400) {
                totalCost = 400;
            }
            
            DecimalFormat df = new DecimalFormat("###");
            return Math.max(Double.parseDouble(df.format(totalCost)), MINIMUM_DELIVERY_AMOUNT);
        }
    
}