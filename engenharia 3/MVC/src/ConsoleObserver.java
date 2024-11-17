class ConsoleObserver implements TaskObserver {
    @Override
    public void update(String message) {
        System.out.println("Notificação: " + message);
    }
}