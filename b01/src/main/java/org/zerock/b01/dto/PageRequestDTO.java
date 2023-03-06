package org.zerock.b01.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {
    @Builder.Default
    private int page = 1;

    @Builder.Default
    private int size = 10;

    private String type; // t,c,w

    private String keyword;

    private String link; //결과를 문자열로 구성

    public String[] getTypes() {
        if (type == null || type.isEmpty()) {
            return null;
        }
        return type.split("");
    }

    public PageRequest getPageable(String ...props) {
        return PageRequest.of(this.page - 1, this.size, Sort.by(props).descending());
    }

    public String getLink() {
        if (link == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("page=").append(this.page);
            stringBuilder.append("&size=").append(this.size);

            if (type != null && type.length() > 0) {
                stringBuilder.append("&type=").append(this.type);
            }
            if (keyword != null) {
                stringBuilder.append("&keyword=").append(URLEncoder.encode(keyword, StandardCharsets.UTF_8));
                link = stringBuilder.toString();
            }
        }

        return link;
    }
}
