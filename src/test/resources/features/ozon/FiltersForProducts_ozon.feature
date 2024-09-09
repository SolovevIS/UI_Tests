#language: ru
@ozon
@ozon-filters
Функционал: Выставление фильтров для продуктов в выбранном разделе

  Сценарий: Выставление фильтров по смартфонам
    И кликнуть на кнопку обновить при старте браузера, если необходимо
    И отклонить запрос на добавление адреса, если необходимо
    И открыть каталог
    И перейти в раздел электроники
    И выбрать подраздел смартфоны
    И сменить текущее окно на "Смартфоны – купить телефон на OZON по низкой цене", если необходимо
    И выставить минимальную цену в "10000"
    И выставить максимальную цену в "15000"
    И сделать скриншот и назвать его "ozone_smartphones_between_10000_and_15000"
    И селенид ждет "3" секунд

  Сценарий: Выставление фильтров по аквашузам
    И кликнуть на кнопку обновить при старте браузера, если необходимо
    И отклонить запрос на добавление адреса, если необходимо
    И открыть каталог
    И перейти в раздел обувь
    И перейти в подраздел аквашузы
    И сменить текущее окно на "Аквашузы женские – купить резиновые тапочки для купания в море (обувь для моря с галькой) на OZON по низкой цене", если необходимо
    И селенид ждет "2" секунд
    И выставить минимальную цену в "2000"
    И селенид ждет "2" секунд
    И выставить максимальную цену в "2500"
    И селенид ждет "3" секунд
    И сделать скриншот и назвать его "подраздел_аквашузы_в_диапазоне_2000_и_2500"