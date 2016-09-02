package com.feicui.edu.gitdriod.favorite.model;

import android.support.annotation.NonNull;
import com.feicui.edu.gitdriod.favorite.model.LocalRepo;
import com.feicui.edu.gitdriod.github.model.Repo;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16-9-2.
 */

public class RepoConverter {
    /**
     * 将一个仓库数据转换为本地仓库数据
     * @param repo
     * @return
     */
    public static @NonNull
    LocalRepo convert(@NonNull Repo repo){
        LocalRepo localRepo = new LocalRepo();
        /**
         "id": 22374063,
         "name": "android-best-practices",
         "full_name": "futurice/android-best-practices",
         "avatar_url": "https://avatars.githubusercontent.com/u/852157?v=3",
         "description": "Do's and Don'ts for Android development, by Futurice developers",
         "stargazers_count": 10469,
         "forks_count": 1974
         */
        localRepo.setId(repo.getId());
        localRepo.setName(repo.getName());
        localRepo.setFullName(repo.getFullName());
        localRepo.setAvatarUrl(repo.getOwner().getAvatar());
        localRepo.setDescription(repo.getDescription());
        localRepo.setStargazersCount(repo.getStarCount());
        localRepo.setForksCount(repo.getForksCount());
        localRepo.setRepoGroup(null);
        return localRepo;
    }

    //集合转换
    public static @NonNull
    List<LocalRepo> convertAll(@NonNull List<Repo> repos){
        ArrayList<LocalRepo> localRepos = new ArrayList<>();
        for (Repo repo:repos) {
            localRepos.add(convert(repo));
        }
        return localRepos;
    }
}
