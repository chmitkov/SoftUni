package ch.productshop.service;

import ch.productshop.domain.dtos.UserSeedDto;

public interface UserService {

    void seedUsers(UserSeedDto[] userSeedDtos);
}
