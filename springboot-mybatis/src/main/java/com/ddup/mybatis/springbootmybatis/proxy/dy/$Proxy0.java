//package com.ddup.mybatis.springbootmybatis.proxy.dy;
//
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//import java.lang.reflect.Proxy;
//import java.lang.reflect.UndeclaredThrowableException;
//import proxy.dynamicproxy.Person;
//
// 反编译代理类
//public final class $Proxy0
//  extends Proxy
//  implements Person
//{
//  private static Method m1;
//  private static Method m2;
//  private static Method m3;
//  private static Method m0;
//
//  public $Proxy0(InvocationHandler paramInvocationHandler)
//    throws
//  {
//    super(paramInvocationHandler);
//  }
//
//  public final boolean equals(Object paramObject)
//    throws
//  {
//    try
//    {
//      return ((Boolean)this.h.invoke(this, m1, new Object[] { paramObject })).booleanValue();
//    }
//    catch (Error|RuntimeException localError)
//    {
//      throw localError;
//    }
//    catch (Throwable localThrowable)
//    {
//      throw new UndeclaredThrowableException(localThrowable);
//    }
//  }
//
//  public final String toString()
//    throws
//  {
//    try
//    {
//      return (String)this.h.invoke(this, m2, null);
//    }
//    catch (Error|RuntimeException localError)
//    {
//      throw localError;
//    }
//    catch (Throwable localThrowable)
//    {
//      throw new UndeclaredThrowableException(localThrowable);
//    }
//  }
//
//  public final void giveMoney()
//    throws
//  {
//    try
//    {
//      this.h.invoke(this, m3, null);
//      return;
//    }
//    catch (Error|RuntimeException localError)
//    {
//      throw localError;
//    }
//    catch (Throwable localThrowable)
//    {
//      throw new UndeclaredThrowableException(localThrowable);
//    }
//  }
//
//  public final int hashCode()
//    throws
//  {
//    try
//    {
//      return ((Integer)this.h.invoke(this, m0, null)).intValue();
//    }
//    catch (Error|RuntimeException localError)
//    {
//      throw localError;
//    }
//    catch (Throwable localThrowable)
//    {
//      throw new UndeclaredThrowableException(localThrowable);
//    }
//  }
//
//  static
//  {
//    try
//    {
//      m1 = Class.forName("java.lang.Object").getMethod("equals", new Class[] { Class.forName("java.lang.Object") });
//      m2 = Class.forName("java.lang.Object").getMethod("toString", new Class[0]);
//      m3 = Class.forName("proxy.dynamicproxy.Person").getMethod("giveMoney", new Class[0]);
//      m0 = Class.forName("java.lang.Object").getMethod("hashCode", new Class[0]);
//      return;
//    }
//    catch (NoSuchMethodException localNoSuchMethodException)
//    {
//      throw new NoSuchMethodError(localNoSuchMethodException.getMessage());
//    }
//    catch (ClassNotFoundException localClassNotFoundException)
//    {
//      throw new NoClassDefFoundError(localClassNotFoundException.getMessage());
//    }
//  }
//}