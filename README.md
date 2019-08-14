# java 反射

### 反射的定义：
将类中的各个组成部分封装成其他对象来进行操作。
### 反射的优点：
1. 可以在程序运行过程中，可以操作这些对象
2. 可以解耦，提高程序的可拓展性能
### 获取class对象的方式
1. `Class.forName("全类名")`:将字节码文件加载进内存，返回Class对象
2. `ClassName.class`:在内存内中，通过类名的属性class来获取
3. `Object.getClass()`:在getClass()方法来获取对象
### Class对象功能:
1. 获取成员变量
    - Field[] getFields() 只能获取public的成员变量
    - Field getField(String name) 只能获取public的成员变量
    - Field[] getDeclaredFields() 能获取全部变量
    - Field getDeclaredField(String name) 能获取全部变量
2. 获取构造方法
    - Constructor<?> getConstructor()
    - Constructor<T> getConstructor()
    - Constructor<?> getDeclaredConstructor()
    - Constructor<T> getDeclaredConstructor()
3. 获取成员方法
    - Method[] getMethods()
    - Method getMethod(String name,Class<?> ...parameterTypes)
    - Method[] getDeclaredMethods()
    - Method getDeclaredMethod(String name, Class<?> ...parameterType)
4. 获取类名
    - String getName()    
 
### Field的成员变量
    1. 设置值
    void set(Object obj, Object value) 
    2. 获取值
    get(Object)
    3. 忽略访问权限修饰符的安全检查 进行暴力反射
    setAccessible(true)    
### Constructor
    1. 创建对象
    newInstance(Object... initargs)
    2. 如果要构建空参数的对象，使用Class对象的newInstance()
 
### Method
    1. 执行方法
    invoke(Object object,object... args)
        