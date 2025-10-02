package concurrency.ch1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CachingFactorizer implements Servlet {

    private BigInteger lastNumber; // 10
    private BigInteger[] lastFactor; // {2, 5}
    private long hits;
    private long cacheHits;

    public synchronized long getHits() {
        return hits;
    }

    public synchronized double getCacheHitRation() {
        return (double) cacheHits / (double) hits;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        var number = extractFromRequest(req);
        BigInteger[] factors = null;

        synchronized (this) {
            ++hits;
            if (number.equals(lastNumber)) {
                ++cacheHits;
                factors = lastFactor;
            }
        }

        if (factors == null) {
            factors = factor(number);
            synchronized (this) {
                lastFactor = factors.clone();
                lastNumber = number;
            }
        }
        encodeIntoResponse(res, factors);

    }

    private BigInteger[] factor(BigInteger n) {
        return new BigInteger[] {n};
    }

    private BigInteger extractFromRequest(ServletRequest req) throws IOException {
        try (BufferedReader reader = req.getReader()) {
            return new BigInteger(reader.readLine());
        }
    }

    private void encodeIntoResponse(ServletResponse res, BigInteger[] factors) throws IOException {
        try (PrintWriter writer = res.getWriter()) {
            res.setContentType("text/plain");
            writer.print(Arrays.toString(factors));
        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return "";
    }

    @Override
    public void destroy() {

    }
}