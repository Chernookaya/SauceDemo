# **#SauceDemo сhecklist for standard_user**
### LoginPage</br>
### [saucedemo.com](https://www.saucedemo.com/)</br>

* Войти в приложение  с валидными логиноп/паролем (**standard_user**/**secret_sauce**)</br>
* Сообщенеи об ошибке, при пустом поле **user-name:** **Epic sadface: Username is required**</br>
* Сообщенеи об ошибке, при пустом поле  **password:** **Epic sadface: Password is required**</br> 
* Сообщение об ошибке при вводе невалидных значений в поле **user-name:** **Epic sadface: Username and password do not match any user in this service**</br> 
* Сообщение об ошибке при вводе невалидных значений в поле **password:** **Epic sadface: Username and password do not match any user in this service**</br> 

### ProductsPage 

* Выбрать один товар для добавления в корзину по кнопке **Add to cart**</br>
* Выбрать несколько товаров для добавления в корзину по кнопке **Add to cart**</br>
* Отменить добавление одного товара в корзину **Remove**</br>
* Отменить добавление нескольких товаров в корзину **Remove**</br>
* Выполнить сортировку по алфавиту в порядке возрастания **(Name (A to Z)**</br>
* Выполнить сортировку по алфавиту в порядке убывания **(Name (Z to A)**</br>
* Выполнить сортировку по цене в порядке убывания Price  **(high to low)**</br>
* Выполнить сортировку по цене в порядке убывания Price **(low to high)**</br>
* Провалиться на страницу товара по ссылке в наименовании товара</br>
* Переход на страницу корзины **CartPage**</br>

### Burger-menu

* Отображение всех товаров на странице  **ProductsPage** по пункту меню **All Items**</br>
* Отображение информации о магазине по пункту меню **About**</br>
* Возврат  на страницу LoginPage по пункту меню Logout</br>
* Возрат к состоянию страницы по умолчанию по пункту меню **Reset App State**</br>


### Product description page

* Отображение информации о товаре, стоимости</br>
* Добавление товара в корзину по кнопке **Add to cart**</br>
* Отмена добавления товара по кнопке **Remove**</br>
* Переход на страницу корзины **CartPage**</br>
* Возврат к странице **ProductsPage**</br>

### CartPage

* Отображение названия страницы **Your Cart**</br>
* Отображение информации о товаре (товарах), стоимости</br>
* Отображение  выбранного товара (товаров) в корзине</br>
* Удаление товара (товаров) из корзины по кнопке **<Remove>**</br>
* Изменение количества товаров в поле **QTY**</br>
* Возврат на страницу выбора товаров **ProductsPage**</br>
* Переход на страницу оплаты **Checkout** по кнопке **Checkout**</br>


### CheckoutPage

* Отображение названия страницы **Checkout: Your Information**</br>
* Страница оформления заказа **Checkout** содержит поля **First Name**, **Last Name**, **Zip/Postal Code**</br>
* Поля **First Name**, **Last Name**, **Zip/Postal Code** обязательные для заполнения</br>
* Поле ввода **First Name** заполняется</br>
* Поле ввода **Last Name** заполняется</br>
* Поле ввода **Zip/Postal Code** заполняется</br>
* Вывод сообещения об ошибке: **Error: First Name is required!**, если поле  **First Name** не заполнено</br>
* Вывод сообещения об ошибке: **Error: Last Name is required!**, если поле  **Last Name** не заполнено</br>
* Вывод сообещения об ошибке: **Error: Postal Code is required!**, если поле  Zip/Postal Code не заполнено</br>
* Переход к странице подтвержения товара **Checkout: Overview** по кнопке **Continue**</br>
* Возврат на страницу корзины **CartPage** по кнопке **Cancel**</br>

### Checkout: OverviewPage

* Отображение названия страницы **Checkout: Complete!**</br>
* Сообщение об успешном оформлении заказа: **Thank you for your order!**</br>
* Текст к сообщениею: **Your order has been dispatched, and will arrive just as fast as the pony can get there!**</br>
* Возврат на страницу **Products** по кнопке **Back Home**</br>
* Очистка полей  **user-name** и **password** при вводе невалидных значений


### Footer

* Переход на [twitter.com](https://twitter.com/saucelabs)
* Переход на [facebook.com](https://www.facebook.com/saucelabs)
* Переход на [linkedin.com](https://www.linkedin.com/company/sauce-labs/)
