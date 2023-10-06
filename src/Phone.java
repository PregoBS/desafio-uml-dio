public class Phone implements Application {
    int currentNumber;
    boolean hasNetworkSignal;
    
    public Phone(int phoneNumber) {
        this.onInit();
        this.currentNumber = phoneNumber;
        this.hasNetworkSignal = true;
    }

    public void setSignal(boolean signal) {
        this.hasNetworkSignal = signal;
    }

    public void call(int phoneNumber) {
        System.out.println("Ligando para o número: " + phoneNumber);
        if (this.hasNetworkSignal)
            System.out.println("chamando .. ");
        else
            System.out.println("Fora da área de cobertura, chamada encerrada");
    }

    public void startVoiceMail(int phoneNumber) {
        if (this.hasNetworkSignal)
            System.out.println("Iniciando correio de voz ao número " + phoneNumber);
        else 
            System.out.println("Fora da área de cobertura, serviço encerrado");
    }

    public void accept(int phoneNumber) {
        System.out.println("Inicializando Telefone..");
    }

    public void onInit() {
        System.out.println("Inicializando Telefone..");
    }
    
    public void onPause() {
        System.out.println("Telefone pausado.");
    }

    public void onResume() {
        System.out.println("Retomando Telefone do ponto em que parou..");
    }

    public void onDestroy() {
        System.out.println("Telefone encerrado. Liberando memória..");
    }
    
}

class PhoneMain {
    public static void main(String[] args) {
        int phoneNumber = 999999999;
        Phone phone = new Phone(phoneNumber);

        phone.call(998888888);
        phone.startVoiceMail(998888888);
        phone.setSignal(false);
        phone.call(989899999);
        phone.startVoiceMail(989899999);
        
        phone.onDestroy();
    }
}