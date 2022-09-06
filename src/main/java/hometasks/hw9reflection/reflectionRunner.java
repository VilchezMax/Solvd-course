package hometasks.hw9reflection;

import com.banking.models.Bank;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class reflectionRunner {

    private static final Logger logger = LogManager.getLogger(reflectionRunner.class);

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<Bank> oneClass = Bank.class;

        String className = oneClass.getName();
        String canonicalName = oneClass.getCanonicalName();
        String simpleName = oneClass.getSimpleName();

        logger.info("Class name: " + className);
        logger.info("Canonical name: " + canonicalName);
        logger.info("Simple name: " + simpleName);
        logger.info("--------------------------------");

        int classModifiers = oneClass.getModifiers();
        logger.info("N° Modifiers: " + classModifiers);
        logger.info("isPublic: " + Modifier.isPublic(classModifiers));
        logger.info("isFinal: " + Modifier.isFinal(classModifiers));
        logger.info("isInterface: " + Modifier.isInterface(classModifiers));
        logger.info("isPrivate: " + Modifier.isPrivate(classModifiers));
        logger.info("isProtected: " + Modifier.isProtected(classModifiers));
        logger.info("isStatic: " + Modifier.isStatic(classModifiers));
        logger.info("isStrict: " + Modifier.isStrict(classModifiers));
        logger.info("isSynchronized: " + Modifier.isSynchronized(classModifiers));
        logger.info("isVolatile: " + Modifier.isVolatile(classModifiers));
        logger.info("isNative: " + Modifier.isNative(classModifiers));
        logger.info("--------------------------------");

        Class<?>[] classInterfaces = oneClass.getInterfaces();
        Arrays.stream(classInterfaces)
                .map(Class::getSimpleName)
                .forEach(System.out::println);

        Class<? super Bank> superClass = oneClass.getSuperclass();
        String superClassName = superClass.getSimpleName();
        logger.info("Super class: " + superClass);
        logger.info("SuperClass name: " + superClassName);

        Class<?> declaringClass = oneClass.getDeclaringClass();
        Class<?> enclosingClass = oneClass.getEnclosingClass();
        logger.info("Declaring Class: " + declaringClass);
        logger.info("Enclosing Class: " + enclosingClass);
        logger.info("--------------------------------");

        Method[] classMethods = oneClass.getMethods();
        logger.info("CLASS METHODS:");
        Arrays.stream(classMethods).forEach(m -> {
            logger.info("---- Method name: " + m.getName() + "() ----");
            logger.info("- Modifiers: " + m.getModifiers());
            logger.info(" Parameter types: ");
            Arrays.stream(m.getParameterTypes()).forEach(logger::info);
            logger.info(" Return types: " + m.getReturnType());
        });
        logger.info("--------------------------------");
        Object constructed = null;
        Constructor<Bank> constructor = null;
        try {
            constructor = oneClass.getConstructor(new Class[]{String.class});
            constructed = oneClass.getConstructor(String.class).newInstance("Solvd Bank");
        } catch (NoSuchMethodException | InvocationTargetException |
                InstantiationException | IllegalAccessException e) {
            logger.warn(e);
        }

        Method toString = constructed.getClass().getMethod("toString");

        logger.info("INSTANCE OF BANK CREATED:");
        Bank solvdBank = (Bank) constructor.newInstance("Solvd bank");
        logger.info("Bank name:" + solvdBank.getName());
    }


}
