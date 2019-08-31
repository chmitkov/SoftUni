package exodia2.service;

import exodia2.domain.entities.User;
import exodia2.domain.models.service.UserServiceModel;
import exodia2.repository.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean registerUser(UserServiceModel userServiceModel) {
        User user = this.modelMapper
                .map(userServiceModel, User.class);
        user.setPassword(DigestUtils.sha256Hex(user.getPassword()));

        try {
            this.userRepository.saveAndFlush(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public UserServiceModel loginUser(UserServiceModel userServiceModel) {
        return this.userRepository
                .findByUsername(userServiceModel.getUsername())
                .filter(u -> u.getPassword()
                        .equals(DigestUtils.sha256Hex(userServiceModel.getPassword())))
                .map(u -> this.modelMapper.map(u, UserServiceModel.class))
                .orElse(null);
//
//
//        User user = this.userRepository
//                .findByUsername(userServiceModel.getUsername())
//                .orElse(null);
//
//        if (user == null || !user.getPassword()
//                .equals(DigestUtils.sha256Hex(userServiceModel.getPassword()))) {
//            return null;
//        }
//
//        return this.modelMapper.map(user, UserServiceModel.class);
    }
}
