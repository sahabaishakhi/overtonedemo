(ns insane-noises.core
  (:use [overtone.live]
        [overtone.synth.sampled-piano]))


;; (definst chime [freq 440]
;;   (let [fund freq
;;         over1 (* 2 fund)
;;         over2 (* 3 fund)
;;         over3 (* 6 fund)]
;;     (pan2 (+ (* (sin-osc fund) 1)
;;              (* (sin-osc over1) 0.7)
;;              (* (sin-osc over2) 0.2)
;;              (* (sin-osc over3) 0.1)))))


;;   (chime 440)
;;   (stop)


;;   (sampled-piano)

;;   (sampled-piano (note :D4))


;;   ;;programming code to map a function over a sequence

;;   (doseq [note (chord :C4 :minor)]
;;     (sampled-piano note))

;;   (doseq [note (scale :C4 :minor)]
;;     (sampled-piano note))

;;   (doseq [note (scale :C4 :minor)]
;;     (Thread/sleep 200)
;;     (sampled-piano note))

;; ;;   linear - attack, sustain and decay

;;   (demo 5 (pan2 (* (env-gen (lin 1 2 1)) (sin-osc 440))))

;;   (demo 5 (pan2 (lf-tri 440)))

;;   (demo 5 (saw (lf-tri 440)))

;;   (demo 5 (pan2 (white-noise)))

;;   (definst hi-hat [strum 0.1]
;;     (pan2 (* (env-gen (perc 0 strum :curve -9)) (white-noise))))

;; ;;   perc - sustain and decay

;;   (hi-hat 0.5)

;;   (definst hi-hat [strum 0.1]
;;     (pan2 (* 2 (env-gen (perc 0 strum :curve -9)) (hpf (white-noise) 9000))))

;;   (demo 5 (pan2 (sin-osc (+ 440 (* (sin-osc 1) 20)))))

;;   (definst choir [freq 880 dur 7]
;;     (let [fund freq
;;           fifth (* fund 3/2)]
;;       (pan2 (+ (lf-tri fund) (lf-tri fifth)))))

;;   (choir)

;;   (definst choir [freq 880 dur 7]
;;     (let [fund freq
;;           fifth (* fund 3/2)
;;           vib-fq 5
;;           vib-mag 13]
;;       (pan2 (* (+ (lf-tri (+ fund (* (sin-osc vib-fq) vib-mag)))
;;                   (lf-tri (+ fifth (* (sin-osc vib-fq) vib-mag))))
;;                (- 1 (* (sin-osc 0.25) 0.25))
;;                (* 0.25 (sin-osc 1)))))

;;   (defn play-pattern [cur-t sep-t seq sound]
;;     (at cur-t (when (first seq) (apply sound (first seq))))
;;     (let [new-t (+ cur-t sep-t)]
;;       (apply-by new-t #'play-pattern [new-t sep-t (rest seq) sound])))

;;   (play-pattern (now) 200 (cycle [[] nil nil [0.5] nil nil [] nil]) hi-hat)

;; (defsynth foo [freq 200 dur 0.5]
;;   (let [src (saw [freq (* freq 1.01) (* 0.99 freq)])
;;         low (sin-osc (/ freq 2))
;;         filt (lpf src (line:kr (* 10 freq) freq 10))
;;         env (env-gen (perc 0.1 dur) :action FREE)]
;;     (out 0 (pan2 (* 0.8 low env filt)))))


;;Envelopes


;; (let [env (envelope [0 0.5 1] [1 1] :step)]
;;   (demo (sin-osc :freq (+ 200 (* 200 (env-gen env :action FREE))))))

;; (let [env (envelope [0 0.5 1] [1 1] :lin)]
;;   (demo (sin-osc :freq (+ 200 (* 200 (env-gen env :action FREE))))))


;; (let [env (envelope [0 1] [2] :sqr)]
;;   (demo (sin-osc :freq (+ 200 (* 200 (env-gen env :action FREE))))))

;; (demo (* (env-gen (lin 0.1 1 1 0.25) :action FREE) (sin-osc)))

;; (demo (let [dur 1
;;             env (sin-osc:kr (/ 1 (* 2 dur)))]
;;         (line:kr 0 1 dur :action FREE)
;;         (* env (saw 220))))

;; (demo (let [dur 1
;;             env (abs (sin-osc:kr (/ 1 dur)))]
;;         (line:kr 0 1 dur :action FREE)
;;         (* env (saw 220))))

;; (demo (let [dur 1
;;             env (abs (sin-osc:kr :freq (/ 1 dur) :mul 0.5 :add 1))]
;;         (line:kr 0 1 dur :action FREE)
;;         (* env (saw 220))))

;; (demo (let [dur 1
;;             env (abs (lf-saw :freq (/ 1 dur) :mul 0.5 :add 1))]
;;         (line:kr 0 1 dur :action FREE)
;;         (* env (saw 220))))
