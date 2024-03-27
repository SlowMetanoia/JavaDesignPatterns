package patterns.behavior.observer.code;

/**
 * "Наблюдаемое"
 * Интерфейс издателя.
 * Содержит методы добавления/удаления и оповещения подписчиков.
 */
public interface Observable {
    /**
     * Регистрация подписичка
     *
     * @param observer подписчик, который будет зарегистрирован на получение овоещениц.
     */
    void registerObserver(Observer observer);

    /**
     * Удаление подписчика.
     *
     * @param observer подписчик, который будет больше не будет получать оповещения.
     */
    void removeObserver(Observer observer);

    void notifyObservers();
}
