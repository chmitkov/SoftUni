public class GravityMoon {
        //Силата на гравитационното поле на луната е
        // приблизително 17% от това на земята.
        // Напишете програма, коятода изчислява тежестта на човек
        // на луната, по дадената тежест на земята.
        public static void main(String[] arguments) {
            double weight = 80, moonw = (weight/100)*17;
            System.out.println("The weight is "+moonw+"kg.");
        }
}

