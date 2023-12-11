package nextstep.courses.domain.session;

public class SessionFee {

    private final long fee;
    private final int limitedEnrollment;


    public SessionFee(long fee, int limitedEnrollment) {
        this.fee = fee;
        this.limitedEnrollment = limitedEnrollment;
    }

    public int limitedEnrollment() {
        return limitedEnrollment;
    }

    public boolean isFree() {
        return fee == 0;
    }

    public long value() {
        return fee;
    }

    public boolean isOverEnrollmentCount(int enrollmentCount) {
        return enrollmentCount > limitedEnrollment;
    }
}
