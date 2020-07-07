package rj.spring.musicrecommendation.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import rj.spring.musicrecommendation.models.Songs;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface SongsRepository extends CrudRepository<Songs, Long> {

    Optional<List<Songs>> findByNameContainingIgnoreCase(String name);

    Optional<Songs> findBySongId(String songId);

    @Query(value = "SELECT s FROM Songs s order by s.popularity desc")
    Page<Songs> findTopKSongsByPopularity(Pageable pageable);

    List<Songs> findAllBySongIdIn(Set<String> var1);

}
