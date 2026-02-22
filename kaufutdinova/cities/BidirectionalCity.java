package ru.kaufutdinova.cities;
//BidirectionalCity делает дороги двусторонними.
public class BidirectionalCity extends City {

    public BidirectionalCity(String name) {
        super(name);
    }

    // Добавляет дорогу в ОБЕ стороны
    @Override
    public void addRoad(City to, int price) {
        if (to == this) return;
        // Нельзя в себя
        if (getRoads().containsKey(to)) return;
        // дорога уже есть или нет?

        // Добавляем прямую дорогу
        super.addOneWayRoad(to, price);

        // Добавляем обратную дорогу (если её ещё нет)
        if (!to.getRoads().containsKey(this)) {
            to.addOneWayRoad(this, price);
        }
    }

    // При удалении удаляем и обратную
    @Override
    public void removeRoad(City to) {
        super.removeRoad(to);
        to.removeRoad(this);
    }
}