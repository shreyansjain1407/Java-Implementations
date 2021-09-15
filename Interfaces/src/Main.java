public class Main {
    public static void main(String[] args) {
        ITelephone sjphone = new DeskPhone(12345);
        sjphone.powerOn();
        sjphone.callPhone(12345);
        sjphone.answer();


        sjphone = new MobilePhone(98765);
        sjphone.powerOn();
        sjphone.callPhone(98765);
        sjphone.answer();
    }
}
