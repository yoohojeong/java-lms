package nextstep.courses.domain.session;

import nextstep.courses.domain.coverimage.CoverImage;
import nextstep.payments.domain.Payment;

public class Session {

    private static final int UNLIMITED_ENROLLMENT = 0;
    private static final long FREE_FEE = 0L;
    private final Long id;
    private final CoverImage coverImage;
    private final Period period;
    private final SessionFee sessionFee;
    private SessionStatus sessionStatus;

    private Session(Long id, CoverImage coverImage, Period period, SessionFee sessionFee, SessionStatus sessionStatus) {
        this.id = id;
        this.sessionFee = sessionFee;
        this.coverImage = coverImage;
        this.period = period;
        this.sessionStatus = sessionStatus;
    }

    public Session(SessionStatus sessionStatus) {
        this(null, null, null, new SessionFee(FREE_FEE, 0), sessionStatus);
    }

    public static Session createFreeSession(CoverImage coverImage, Period period) {
        SessionStatus sessionStatus = updateSessionStatusToEnrollmentOpenOrPreparing(period);
        return new Session(null, coverImage, period, new SessionFee(FREE_FEE, UNLIMITED_ENROLLMENT), sessionStatus);
    }

    public static Session createPaidSession(CoverImage coverImage, Period period, SessionFee sessionFee) {
        SessionStatus sessionStatus = updateSessionStatusToEnrollmentOpenOrPreparing(period);
        return new Session(null, coverImage, period, sessionFee, sessionStatus);
    }

    public SessionFee sessionFee() {
        return sessionFee;
    }

    public boolean isOpened() {
        return sessionStatus.equals(SessionStatus.ENROLLMENT_OPEN);
    }

    public boolean isEnrollmentAmountValid(Payment payment) {
        if (sessionFee.isFree()) {
            return true;
        }
        return payment.isSameAmount(sessionFee);
    }

    public boolean isExceededMaxEnrollment(int enrollmentCount) {
        if (sessionFee.isFree()) {
            return false;
        }
        return sessionFee.isOverEnrollmentCount(enrollmentCount);
    }

    private static SessionStatus updateSessionStatusToEnrollmentOpenOrPreparing(Period period) {
        if (period.isEqualStartDateAndToday()) {
            return SessionStatus.ENROLLMENT_OPEN;
        }
        return SessionStatus.PREPARING;
    }
}
