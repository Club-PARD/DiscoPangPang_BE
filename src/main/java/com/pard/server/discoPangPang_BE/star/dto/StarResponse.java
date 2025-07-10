package com.pard.server.discoPangPang_BE.star.dto;


import lombok.*;

import java.util.UUID;


@Getter
@Builder
public class StarResponse {
    private String s;
    private String t;
    private String a;
    private String r;
    private String l;
    private UUID projectId;
}
