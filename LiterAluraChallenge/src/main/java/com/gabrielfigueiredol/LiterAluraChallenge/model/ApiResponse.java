package com.gabrielfigueiredol.LiterAluraChallenge.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ApiResponse(Integer count,
                          List<BookResponse> results) {
}
