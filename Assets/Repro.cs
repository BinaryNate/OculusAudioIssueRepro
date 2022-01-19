using System.Collections;
using UnityEngine;

class Repro : MonoBehaviour {

    AndroidJavaClass _reproJavaClass;

    void Start() {

        _reproJavaClass = new AndroidJavaClass("com.vuplex.repro.Repro");
        _reproJavaClass.CallStatic("createGeckoSession");
    }

    // Repro.java invokes this method after it creates the GeckoSession.
    void OnGeckoSessionCreated() {

        StartCoroutine(_closeSessionAfterDelay());
    }

    IEnumerator _closeSessionAfterDelay() {

        yield return new WaitForSeconds(3);
        _reproJavaClass.CallStatic("closeGeckoSession");
    }
}
