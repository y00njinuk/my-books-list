package chapter2.item6.adapater;

public final class MovableAdapterImpl implements MovableAdapter {
    private Movable luxuryCars;

    public MovableAdapterImpl(Movable bugattiVeyron) {
        luxuryCars = bugattiVeyron;
    }

    @Override
    public double getSpeed() {
        return convertMPHtoKMPH(luxuryCars.getSpeed());
    }

    private double convertMPHtoKMPH(double mph) {
        return mph * 1.60934;
    }
}
