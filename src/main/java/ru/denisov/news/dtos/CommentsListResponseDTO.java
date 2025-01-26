package ru.denisov.news.dtos;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentsListResponseDTO {

  private List<CommentResponseDTO> comments = new ArrayList<>();

}
