#language: ru
  @baseApi
Функционал: базовые и фиксированные запросы к сайту ReqRes

  Сценарий: базовый фиксированный get
    И сделать фиксированный get запрос к апи по пути "users/2"

  Сценарий: базовый фиксированный post
    И сделать фиксированный post запрос к апи по пути "users"

  Сценарий: базовый фиксированный put
    И сделать фиксированный put запрос к апи по пути "users/2"

  Сценарий: базовый фиксированный delete
    И сделать фиксированный delete запрос к апи по пути "users/2"