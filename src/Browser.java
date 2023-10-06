public class Browser implements Application {
    String currentPage;
    int openTabs;
    
    public Browser() {
        this.onInit();

        this.currentPage = "";
        this.openTabs = 0;
    }

    public void showPage() {
        if (currentPage.isBlank()) return;

        System.out.println("Exibindo a página: " + this.currentPage);
    }

    public void addNewTab(String page) {
        this.openTabs += 1;
        this.currentPage = page;
        System.out.println("Nova aba criada com a página: " + page);
        System.out.println("Total de abas: " + this.openTabs);
    }

    public void refreshPage() {
        if (currentPage.isBlank()) return;

        System.out.println("Atualizando a página: " + this.currentPage);
        this.showPage();
    }

    public void onInit() {
        System.out.println("Inicializando Browser..");
    }
    
    public void onPause() {
        System.out.println("Browser pausado.");
    }

    public void onResume() {
        System.out.println("Retomando Browser do ponto em que pausou..");
    }

    public void onDestroy() {
        System.out.println("Browser encerrado. Liberando memória..");
    }
}

class BrowserMain {
    public static void main(String[] args) {
        Browser browser = new Browser();

        browser.addNewTab("https://dio.me");
        browser.showPage();
        browser.refreshPage();

        browser.onDestroy();
    }
}