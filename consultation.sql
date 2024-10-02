-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 02 oct. 2024 à 08:28
-- Version du serveur : 10.4.27-MariaDB
-- Version de PHP : 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `consultation`
--

-- --------------------------------------------------------

--
-- Structure de la table `attente`
--

CREATE TABLE `attente` (
  `id` int(11) NOT NULL,
  `idS` int(11) NOT NULL,
  `date_de_retour` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `attente`
--

INSERT INTO `attente` (`id`, `idS`, `date_de_retour`) VALUES
(30, 54, '2023-07-21 21:00:00'),
(31, 55, '2023-07-15 21:00:00');

-- --------------------------------------------------------

--
-- Structure de la table `bureau`
--

CREATE TABLE `bureau` (
  `id` int(11) NOT NULL,
  `nom` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `bureau`
--

INSERT INTO `bureau` (`id`, `nom`) VALUES
(1, 'ORGANISME SOUS TUTELLE ET RATTACHES'),
(2, 'DIRECTION RATTACHEES AU SECRETARIAT GENERAL'),
(3, 'DIRECTION GENERAL DE L\'ENSEIGNEMENT SUPERIEUR '),
(4, 'DIRECTION GENERAL DE LA RECHERCHE SCIENTIFIQUE');

-- --------------------------------------------------------

--
-- Structure de la table `consultation`
--

CREATE TABLE `consultation` (
  `id` int(11) NOT NULL,
  `date_heure` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `motif` varchar(200) DEFAULT NULL,
  `idV` int(11) NOT NULL,
  `idD` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `consultation`
--

INSERT INTO `consultation` (`id`, `date_heure`, `motif`, `idV`, `idD`) VALUES
(56, '2023-07-09 17:25:28', 'entretien', 52, 9),
(57, '2023-07-09 17:36:55', 'entretien', 53, 17),
(58, '2024-10-02 06:26:28', 'certification', 54, 18);

-- --------------------------------------------------------

--
-- Structure de la table `direction`
--

CREATE TABLE `direction` (
  `id` int(11) NOT NULL,
  `acronyme` varchar(250) NOT NULL,
  `nomination` varchar(350) NOT NULL,
  `idB` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `direction`
--

INSERT INTO `direction` (`id`, `acronyme`, `nomination`, `idB`) VALUES
(1, 'CPU', 'Conférences des Présidents des Universités', 1),
(2, 'CNH', 'Conseil Nationnal d\'Habilitation', 1),
(3, 'CRFM', 'Commution de Rerence pour les Formations Médicales', 1),
(4, 'CROU', 'Centre Regional des Oeuvres Universitaires', 1),
(5, 'FUM', 'Foyers Universitaires Malgaches', 1),
(6, 'DGES', 'Direction Générale de l\'Enseignement Supérieur', 2),
(7, 'DGRS', 'Direction Générale de la Recherche Supérieur', 2),
(8, 'DAFF', 'Direction Des Affaires Administratives', 2),
(9, 'DAJ', 'Direction des Affaires Juridiques', 2),
(10, 'DIRCOM', 'Direction de la Communication', 2),
(11, 'DSSIP', 'Direction de la Statistique, du Système d\'Information et Plannification', 2),
(12, 'DBNE', 'Direction des Bourses Nationales et Extérieures', 2),
(13, 'DRSE', 'Direction des Reformes, des Suivi et Evaluation', 2),
(14, 'DDCP', 'Direction du Dévelopement et de Coordination du Partenariat', 2),
(15, 'DRH', 'Direction des Ressources Humaines', 2),
(16, 'DES', 'Direction de l\'Ensiegnement Supérieur', 3),
(17, 'DAAQ', 'Direction de l\'Accréditation, de l\'Assurance Qualité', 3),
(18, 'IST', 'Instituts Supérieurs de la Téchnologie', 3),
(19, 'CNTEMAD', 'Centre National de Télé-Enseignement de Madagascar', 3),
(20, 'CNELA', 'Centre National de l\'Enseignement de la Langue Anglaise', 3),
(21, 'DRI', 'Direction de la Recherche et de l\'Inovation', 4),
(22, 'CNRO', 'Centre National de Recherches Océanographiques', 4),
(23, 'CNARP', 'Centre National d\'Application des Recherches Pharmaceutiques', 4),
(24, 'CNRIT', 'Centre National de Recherches Industrielles et Technologiques', 4),
(25, 'CIDST', 'Centre d\'Information et de Documentation Scientifique', 4),
(26, 'CNRE', 'Centre NAtional de Recherche pour l\'Environnement', 4),
(27, 'INSTN', 'Institut National des Sciences et Techniques Nucléaires', 4),
(28, 'IMVAVET', 'Institut Malgache des Vaccins Vétérinaires', 4),
(37, 'PBZT', 'Parc Botanique et Zoologique de Tsimbazaza', 4),
(38, 'FOFIFA', 'Foibem-pirenena momba ny Fikarohana ampiharina amin\'ny Fampandrosoana ny eny ambanivohitra', 4);

-- --------------------------------------------------------

--
-- Structure de la table `sortie`
--

CREATE TABLE `sortie` (
  `id` int(11) NOT NULL,
  `date_heure` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `idC` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `sortie`
--

INSERT INTO `sortie` (`id`, `date_heure`, `idC`) VALUES
(54, '2023-07-09 17:25:43', 56),
(55, '2023-07-09 17:37:04', 57);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL,
  `nom` varchar(250) NOT NULL,
  `prenom` varchar(250) DEFAULT NULL,
  `age` int(11) NOT NULL,
  `sexe` varchar(200) NOT NULL,
  `photo` varchar(250) DEFAULT NULL,
  `username` varchar(250) NOT NULL,
  `email` varchar(300) NOT NULL,
  `password` varchar(300) NOT NULL,
  `direction` int(11) NOT NULL,
  `type_compte` varchar(100) DEFAULT NULL,
  `date_ajout` timestamp NULL DEFAULT current_timestamp(),
  `date_mise_a_jour` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `nom`, `prenom`, `age`, `sexe`, `photo`, `username`, `email`, `password`, `direction`, `type_compte`, `date_ajout`, `date_mise_a_jour`) VALUES
(10, 'RAFARALAHY', 'Savaka Lucien', 21, 'Homme', 'D:\\LUCIEN\\image\\IMG_20210804_151116.jpg', 'Lucien', 'savakalucien@gmail.com', '123', 11, 'Secretaire', '2023-05-19 06:39:01', '2023-05-18 21:00:00'),
(11, 'test', 'testtttttt', 12, 'Homme', 'C:\\Users\\HP\\Pictures\\Koala.jpg', 'TEST', 'test@gmail.com', '123', 2, 'Autre', '2023-05-19 09:56:40', '2023-05-19 10:03:53'),
(13, 'RAFARALAHY', 'Savaka Lucien', 22, 'Homme', 'C:Users\richaDownloadsCompressedargon-design-system-react-mastersrcassetsimgrandfavicon.png', 'Lucien45', 'lucien@gmail.com', 'lucien123456', 5, 'Secretaire', '2024-10-02 06:23:21', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `visiteur`
--

CREATE TABLE `visiteur` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(200) DEFAULT 'N/A',
  `age` int(11) DEFAULT NULL,
  `sexe` varchar(50) DEFAULT NULL,
  `contact` varchar(255) DEFAULT 'N/A',
  `adresse` varchar(255) DEFAULT 'N/A'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `visiteur`
--

INSERT INTO `visiteur` (`id`, `nom`, `prenom`, `age`, `sexe`, `contact`, `adresse`) VALUES
(52, 'rabe', '', 9, 'Homme', '', 'MAHAMASINA'),
(53, 'rakoto', '', 17, 'Femme', '', 'ANKATSO'),
(54, 'RAKOTO', '', 18, 'Femme', '0325564852', 'Tsiadana');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `attente`
--
ALTER TABLE `attente`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Fk_att_sort` (`idS`);

--
-- Index pour la table `bureau`
--
ALTER TABLE `bureau`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `consultation`
--
ALTER TABLE `consultation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Fk_cons_vis` (`idV`),
  ADD KEY `Fk_cons_dir` (`idD`);

--
-- Index pour la table `direction`
--
ALTER TABLE `direction`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Fk_dir_bir` (`idB`);

--
-- Index pour la table `sortie`
--
ALTER TABLE `sortie`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Fk_sortie_visiteur` (`idC`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_user` (`direction`);

--
-- Index pour la table `visiteur`
--
ALTER TABLE `visiteur`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `attente`
--
ALTER TABLE `attente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT pour la table `bureau`
--
ALTER TABLE `bureau`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `consultation`
--
ALTER TABLE `consultation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;

--
-- AUTO_INCREMENT pour la table `direction`
--
ALTER TABLE `direction`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT pour la table `sortie`
--
ALTER TABLE `sortie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT pour la table `visiteur`
--
ALTER TABLE `visiteur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `attente`
--
ALTER TABLE `attente`
  ADD CONSTRAINT `Fk_att_sort` FOREIGN KEY (`idS`) REFERENCES `sortie` (`id`);

--
-- Contraintes pour la table `consultation`
--
ALTER TABLE `consultation`
  ADD CONSTRAINT `Fk_cons_dir` FOREIGN KEY (`idD`) REFERENCES `direction` (`id`),
  ADD CONSTRAINT `Fk_cons_vis` FOREIGN KEY (`idV`) REFERENCES `visiteur` (`id`);

--
-- Contraintes pour la table `direction`
--
ALTER TABLE `direction`
  ADD CONSTRAINT `Fk_dir_bir` FOREIGN KEY (`idB`) REFERENCES `bureau` (`id`);

--
-- Contraintes pour la table `sortie`
--
ALTER TABLE `sortie`
  ADD CONSTRAINT `Fk_sortie_visiteur` FOREIGN KEY (`idC`) REFERENCES `consultation` (`id`);

--
-- Contraintes pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `fk_user` FOREIGN KEY (`direction`) REFERENCES `direction` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
