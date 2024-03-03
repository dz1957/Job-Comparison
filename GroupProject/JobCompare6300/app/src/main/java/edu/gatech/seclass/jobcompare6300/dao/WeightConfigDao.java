@Dao
public interface WeightConfigDao {
    @Insert
    void insert(WeightConfig weightConfig);

    @Update
    void update(WeightConfig weightConfig);

    @Delete
    void delete(WeightConfig weightConfig);

    @Query("SELECT * FROM WEIGHT_CONFIG")
    List<WeightConfig> getAll();
}