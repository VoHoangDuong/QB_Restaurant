package com.duongvh.restaurant.service.token;


import com.duongvh.restaurant.model.Token;

public interface ITokenService {

    Token createToken(Token token);

    Token findByToken(String token);
}
