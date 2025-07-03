package data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GeneralMenuElements {
    RUNNING("Бег","Все для бега"),
    VOLLEYBALL("Волейбол", "Магазин волейбольных товаров"),
    BASKETBALL("Баскетбол", "Баскетбольные товары"),
    TENNIS("Теннис", "Товары для большого тенниса"),
    PADEL("Падел", "Товары для падел-тенниса"),
    ACTIVE_RECREATION("Активный отдых", "Активный отдых"),
    FOOTWEAR("Обувь", "Спортивная обувь"),
    CLOTHING("Одежда", "Спортивная одежда"),
    BALLS("Мячи","Мячи"),
    ACCESSORIES("Аксессуары", "Спортивные аксессуары"),
    PROMOTIONS("Акции", "Акции - спортивный магазин Kinash Sport"),
    SALE("Распродажа", "Распродажа");


    private final String displayName;
    private final String headText;

}
