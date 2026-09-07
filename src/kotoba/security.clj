(ns kotoba.security
  "Pure Kotoba security operations replacing java.security/java.net

  This library provides JVM-free portable security operations.")

(defn sha256-bytes
  "Compute SHA-256 hash of bytes. Returns byte array. Placeholder."
  [^bytes data]
  (when data
    (let [digest (java.security.MessageDigest/getInstance "SHA-256")]
      (.digest digest ^bytes data))))

(defn generate-keypair
  "Generate a keypair for the given algorithm. Placeholder."
  [algorithm]
  (when (string? algorithm)
    (.generateKeyPair (java.security.KeyPairGenerator/getInstance algorithm))))

(defn get-public
  "Get public key from keypair."
  [kp]
  (.getPublic kp))

(defn get-private
  "Get private key from keypair."
  [kp]
  (.getPrivate kp))

(defn get-encoded
  "Get encoded bytes from key."
  [key]
  (.getEncoded key))

(defn keyfactory
  "Create a KeyFactory instance. Placeholder."
  [algorithm]
  (when (string? algorithm)
    (java.security.KeyFactory/getInstance algorithm)))

(defn pkcs8-spec
  "Create PKCS8EncodedKeySpec from bytes. Placeholder."
  [^bytes key-spec]
  (when key-spec
    (java.security.spec.PKCS8EncodedKeySpec. ^bytes key-spec)))

(defn x509-spec
  "Create X509EncodedKeySpec from bytes. Placeholder."
  [^bytes key-spec]
  (when key-spec
    (java.security.spec.X509EncodedKeySpec. ^bytes key-spec)))

(defn generate-private
  "Generate private key from spec. Placeholder."
  [kf spec]
  (when (and kf spec)
    (.generatePrivate kf spec)))

(defn generate-public
  "Generate public key from spec. Placeholder."
  [kf spec]
  (when (and kf spec)
    (.generatePublic kf spec)))

(defn sign
  "Sign a message with a private key. Placeholder."
  [priv ^bytes msg]
  (when (and priv msg)
    (let [sig (java.security.Signature/getInstance "Ed25519")]
      (.initSign sig priv)
      (.update sig msg)
      (.sign sig))))
