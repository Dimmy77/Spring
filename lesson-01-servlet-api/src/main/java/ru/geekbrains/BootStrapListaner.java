package ru.geekbrains;

import ru.geekbrains.persist.User;
import ru.geekbrains.persist.UserRepository;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class BootStrapListaner implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext= sce.getServletContext();

        UserRepository userRepository = new UserRepository();
        servletContext.setAttribute("userRepository", userRepository);

        userRepository.Insert(new User("Вася"));
        userRepository.Insert(new User("Петя"));
        userRepository.Insert(new User("Федя"));
    }
}
