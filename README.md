## Java实现的网上商城
项目基于jsp & servlet实现，包括完整的前后端

### 功能
- 用户模块(user)：注册、登录、激活、信息修改、退出、记住我
- 分类模块(category)： 增删查改
- 商品模块(product)：分页展示
- 订单模块(order)：增删查改
- 购物车模块(cart): 增删查改

### 依赖
jdk1.7+和tomcat7+

### Demo

### 使用

### FQA
Q：如何实现自动登录和记住我的功能？  
A：通常我们需要在登录表单填写认证信息，比如用户名和密码，后台校验通过后给客户端传一个sessionid，记住登录
状态。自动登录就是省去了填表单这一步骤，在你首次在登录页面登录成功并且勾选了自动登录的复选框后，服务器会把
你的用户名和密码存储在cookie中(可以直接明文或者存md5之后的token)，并设置cookie的有效时间。后面的流程和正常
的登录机制是一样的。在Java里我们可以通过Filter实现。  
"记住我"也是基于cookie，会把存在客户端的用户名和密码直接填到表单里去，省去手动输入的麻烦。