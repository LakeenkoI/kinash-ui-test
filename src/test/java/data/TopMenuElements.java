package data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TopMenuElements {
    SHOPS("Магазины"),
    ABOUT_THE_COMPANY("О компании"),
    DELIVERY("Доставка"),
    WHOLESALE("Опт"),
    RETURNS("Возврат"),
    GIFT_CARDS("Подарочные карты"),
    CONTACTS("Контакты");

    private final String displayName;

}
