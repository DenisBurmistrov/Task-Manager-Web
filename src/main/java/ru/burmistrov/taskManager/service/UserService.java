package ru.burmistrov.taskManager.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.burmistrov.taskManager.api.service.IUserService;
import ru.burmistrov.taskManager.entity.User;
import ru.burmistrov.taskManager.repository.IUserRepository;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    public User save(@NotNull final User user) {
       return userRepository.save(user);
    }

    public void delete(@NotNull final User user){
        userRepository.delete(user);
    }

    public User findOne(@NotNull final String id) {
        return userRepository.findOne(id);
    }

    public User findOneByLogin(@NotNull final String login) {
        return userRepository.findOneByLogin(login);
    }
}
