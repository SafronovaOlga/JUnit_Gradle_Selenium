public class SizeCalculator {        // Класс для расчета стоимости в зависимости от габаритов    // Рассчитывает стоимость доставки в зависимости от габаритов груза.        public double calculateCost(String size) {        if ( size.equals( "большие" ) ){                        return 200;        } else if ( size.equals( "маленькие" ) ) {                        return 100;        } else {                        throw new IllegalArgumentException( "Неверно указаны габариты груза" );        }            }}