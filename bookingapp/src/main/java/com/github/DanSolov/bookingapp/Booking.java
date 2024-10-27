@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private ServiceProvider serviceProvider;

    private LocalDateTime bookingDate;

    // Getters, Setters, Constructors
}
