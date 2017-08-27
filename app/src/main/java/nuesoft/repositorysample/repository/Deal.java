package nuesoft.repositorysample.repository;

import org.jdeferred.Deferred;

/**
 * Created by mysterious on 8/27/17.
 */

public interface Deal {

//    Deferred resolve;
//    Deferred reject;
//
//    public Deal(Deferred resolve, Deferred reject) {
//        this.resolve = resolve;
//        this.reject = reject;
//    }

    void Deal(Deferred resolve, Deferred reject);
}
