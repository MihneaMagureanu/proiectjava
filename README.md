# proiectjava
Proiect Java an 1 semestrul 1
Date carti
Magureanu Mihnea


1.	Introducere
In aceasta aplicatie am construit back-end-ul pentru a face interogari pe o baza de date care contine date despre carti de citit si review-uri la ele. Aceasta aplicatie este folosita pentru  gasirea unei carti de citit, facand cautari dupa review-urile lor si vazand notele date in acele review-uri, sau cautand dupa autori sau personaje din acea carte.
2.	Cum se testeaza
Aplicatia este construita in java cu framework-ul de spring, folosind un server local de tomcat si o baza de date creata in mysql. Pnetru a putea porni aplicatia, este nevoie de aceste doua programe instalate local si de wampserver/xampp pornit. Eu am folosit wampserver deoarece eram mai familiar cu wampserver decat cu xampp. Baza de date contine un table pentru: carti (book ca si route), autori (author), personaje (personaj), review-uri (review) si edituri (publisher). Pentru fiecare din aceste tabele putem face interogarile de baza CRUD, in felul urmator: 
-	*nume controller*/{id} – request get pentru o linie din table
-	*nume controller*/create – request post pentru a crea o linie in table
-	*nume controller*/edit/{id} – request put pentru a edita o linie din table
-	*nume controller*/delete/{id} – request delete pentru a sterge o linie din table
-	*nume controller*/count – returneaza numarul de linii din table
-	*nume controller*/getAll – returneaza toate liniile din table
-	/author/firstname/{name} – returneaza autorul cu acel prenume
-	/author/lastname/{name} – returneaza autorul cu acel nume



3.	Implementarea aplicatiei 
3.1.	Modele
Avem un model pentru fiecare din tabelele mentionate. Inainte de a scrie in parte proprietatile fiecarui model, vom mentiona toate lucrurile pe care le au in comun. Toate clasele au adnotarea “@Entity” pentru a semnala ca dorim sa fie luate in considerare la crearea sau updatarea bazei de date.  Pentru toate modelele avem un constructor fara parametric (numit “bean”), un constructor parametrizat, getteri si setter pentru fiecare proprietate si overload-uri pentru functiile hashCode, equals si toString. De asemenea, pe proprietatea “id” a fiecarui model avem adnotarile “Id” (pentru a semnala ca aceasta este cheia primara) si “@GeneratdValue(strategy = GenerationType = AUTO))” (pentru a genera automat o valoarea pentru campul “id” la adaugarea unei noi linii in baza de date).  
	Clasa Author are urmatoarele proprietati: firstName, lastName si Books. Primele 2 prorietati sunt atomice, in timp ce Books semnaleaza relatia many-to-many dintre clasele Author si Book. In modelul Book avem proprietatile atomice title si isbn, dar si proprietati care indica relatiile din baza de date. Relatia catre tabela Author este marcata cu adnotarea @ManyToMany. Adnotarea @JoinTable ne da optiunea de a exprima clar cum vrem sa fie create tabela de legatura a acestei relatii many-to-many. Avem parametru pentru numele tabelului, author_book, joinColumns si inverseJoinColumns pentru a mention ace coloane dorim si din ce tabele. De asemenea, aceeasi adnotare @ManyToMany este si in modelul Author pe proprietatea Books, care primeste ca si parametru un nume pentru a stii la care relatie many-to-many facem referire. O carte poate avea mai multe personaje si mai multe review-uri, ceea ce a insemnat crearea a doua relatii one-to-many intre tabelele Book si Personaj, respective Book si Review. Crearea acestor relatii a fost facuta cu adnotarea @OneToMany in modelul Book, respective adnotarea @ManyToOne in modelele Personaj si Review. Tabelul Book este si intr-o relatie many-to-one cu tabelul Publisher, asa ca am adnotat proprietatea Publisher din Book cu @ManyToOne, similar cu relatiile descrise mai sus.
	Modelul personaj are proprietatile name si book. Modelul Publisher are proprietatile name, addressLine1, city, state si zip, iar modelul Review are proprietatile Title, Text si Grade.




3.2.	Repositories
Pentru repositories, am creat o interfata care sa corespunda fiecarui model si care extinde CrudRepository, care primeste 2 tipuri. Primul este modelul care corespunde fiecarui model, iar al doilea parametru este tipul de date al id-ului modelului, care a fost Long pentru toate modelele. 



3.3.	DTOs

DTO (data transfer object) sunt niste clase similar cu modelele, dar care nu contin datele de care nu are nevoie utilizatorul sip e care nu vrem sa le trimitem, cum ar fi id-urile din baza de date. Astfel, exista un DTO care corespunde fiecarui model, toate avand implementari similare. Toate DTO-urile contin doi constructori, unul fara parametri si un altul care primeste ca parametru un obiect de tipul modelului care corespunde DTO-ului. De asemenea, exista getteri si setteri pentru fiecare proprietate, la fel ca in modele.  Pentru a putea returna un DTO catre utilizator (spre exemplu pentru un request de tip get) avem nevoie sa punem pe DTO adnotarea @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY).

3.4.	Services
Serviciile sunt clasele in care implementam logica query-urilor de CRUD, pentru a nu avea logica direct in controller. Ofera un plus de securitate si ajuta la crearea unui cod mai usor de citit. Dupa cum am mentionat mai sus, in services sunt implementate metode pentru actiunile de baza CRUD(create, read, update, delete). Avem si functia GetCount, care returneaza numarul de linii din tabelul respective, si GetAll*nume model* care returneaa toate randurile din acea tabela. Pentru a crea un serviciu, cream o clasa la care adaugam adnotarea @Service si in care injectam repository-urile de care avem nevoie.  

3.5.	Controllers
Controllere sunt clasele in care sunt apelate metodele din servicii si in care marcam rutarea fiecarei metode. Adnotarea @RestController semnaleaza ca aceasta clasa este un controller pentru REST API, iar adnotarea @RequestMapping primeste in parametrul “value” ruta pe care intra toate actiunile din controller. In fiecare controller injectam serviciul respective, si avem cate o functie pentru apelarea metodelor definite in servicii. Fiecare metoda are adnotarea *verb*Mapping(value= “”), unde “verb” este verbul http folosit in acea actiune(get, post, put sau delete), iar value este ruta prin care apelam functia. Spre exemplu, AuthorController are adnotarea @RequestMapping(“/author”), iar functia AddAuthor are adnotarea @PostMapping(value=”/create”). Astfel, daca accesam localhost:8080/author/create si trimitem un body cu datele noului autor, putem adauga un nou autor in baza de date. 
	Particularitati intalnite in controller au fost cele pentru parametric. Vedem la ruta metodei GetAuthorById ca ruta este “/{id}”. Inchiderea intre accolade semnifica ca acel element al rutei va veni dintr-un parametru, si in antetul functiei trebuie ca parametrul respective sa aiba adnotarea PathVariable(value=””), unde “value” trebuie sa aiba ca valoare sirul de caractere mentionat in ruta din adnotarea metodei.
	Pentru metodele AddAuthor sau EditAuthor (metode de tip post, respective put), utilizatorul trebuie sa si trimita date pentru a executa acele actiuni. Astfel, parametrul acestor metode este precedat de adnotarea @RequestBody, care mentioneaza ca valoarea acelui parametru va veni din body-ul request-ului.
