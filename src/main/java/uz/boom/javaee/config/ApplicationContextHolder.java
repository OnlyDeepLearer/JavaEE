package uz.boom.javaee.config;

import uz.boom.javaee.dao.UserDao;

public class ApplicationContextHolder {

    public static <T> T getBean(Class<T> clazz) {
        return switch (clazz.getSimpleName()) {
            case "UserDao" -> (T) UserDao.getInstance();
            default -> throw new BeanNotFoundException("Bean not found");
        };
    }

    public static class BeanNotFoundException extends RuntimeException{
        public BeanNotFoundException(String message) {
            super(message);
        }
    }
}