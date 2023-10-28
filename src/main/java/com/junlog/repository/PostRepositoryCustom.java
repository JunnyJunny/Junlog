package com.junlog.repository;

import com.junlog.domain.Post;
import com.junlog.request.PostSearch;

import java.util.List;

public interface PostRepositoryCustom {

    List<Post> getList(PostSearch postSearch);
}
