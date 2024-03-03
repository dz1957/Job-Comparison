@Dao
public interface JobOfferDao {
    @Insert
    void insert(JobOffer jobOffer);

    @Update
    void update(JobOffer jobOffer);

    @Delete
    void delete(JobOffer jobOffer);

    @Query("SELECT * FROM JOB_OFFER")
    List<JobOffer> getAll();
}