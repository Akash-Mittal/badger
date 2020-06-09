package com.am.innovations.badger.enums;

import java.util.Arrays;
import java.util.function.BiFunction;

import org.springframework.http.ResponseEntity;

import com.am.innovations.badger.API;
import com.am.innovations.badger.configurations.yml.BadgesConfiguration;
import com.am.innovations.badger.dto.git.GitRepoResponse;

public enum OPS implements BiFunction<ResponseEntity<GitRepoResponse[]>, BadgesConfiguration, String> {

    GITHUB_BADGES_ALL_REPO {

        @Override
        public String apply(final ResponseEntity<GitRepoResponse[]> t, BadgesConfiguration badgesConfiguration) {
            final StringBuilder stringBuilder = new StringBuilder();
            Arrays.stream(t.getBody()).forEach(repo -> {
                stringBuilder.append(replaceUserNameAndRepoName(badgesConfiguration.getGithub().getIssues(), repo))
                        .append(replaceUserNameAndRepoName(badgesConfiguration.getGithub().getForks(), repo))
                        .append(replaceUserNameAndRepoName(badgesConfiguration.getGithub().getLicense(), repo))
                        .append(replaceUserNameAndRepoName(badgesConfiguration.getGithub().getStars(), repo));
            });
            return stringBuilder.toString();
        }

    },
    SONAR_BADGES_ALL_REPO {
        @Override
        public String apply(final ResponseEntity<GitRepoResponse[]> t, BadgesConfiguration badgesConfiguration) {
            final StringBuilder stringBuilder = new StringBuilder();
            Arrays.stream(t.getBody()).forEach(repo -> {
                stringBuilder.append(replaceUserNameAndRepoName(badgesConfiguration.getSonar().getMeasure(), repo));
            });
            return stringBuilder.toString();
        }

    },
    TRAVIS_BADGES_ALL_REPO {
        @Override
        public String apply(final ResponseEntity<GitRepoResponse[]> t, BadgesConfiguration badgesConfiguration) {
            final StringBuilder stringBuilder = new StringBuilder();
            Arrays.stream(t.getBody()).forEach(repo -> {
                stringBuilder.append(replaceUserNameAndRepoName(badgesConfiguration.getTravis().getStatus(), repo));
            });
            return stringBuilder.toString();
        }

    },
    LGTM_BADGES_ALL_REPO {
        @Override
        public String apply(final ResponseEntity<GitRepoResponse[]> t, BadgesConfiguration badgesConfiguration) {
            final StringBuilder stringBuilder = new StringBuilder();
            Arrays.stream(t.getBody()).forEach(repo -> {
                stringBuilder.append(replaceUserNameAndRepoName(badgesConfiguration.getLgtm().getAlerts(), repo))
                        .append(replaceUserNameAndRepoName(badgesConfiguration.getTravis().getStatus(), repo));
            });
            return stringBuilder.toString();
        }

    },
    GITHUB_CLONE_ALL_REPOS {
        @Override
        public String apply(final ResponseEntity<GitRepoResponse[]> t, BadgesConfiguration badgesConfiguration) {
            final StringBuilder stringBuilder = new StringBuilder();
            Arrays.stream(t.getBody()).forEach(repo -> {
                stringBuilder.append(replaceUserNameAndRepoName(badgesConfiguration.getGithub().getCloneHTTP(), repo));

            });
            return stringBuilder.toString();
        }

    },
    ALL {
        @Override
        public String apply(final ResponseEntity<GitRepoResponse[]> t, final BadgesConfiguration u) {
            final StringBuilder stringBuilder = new StringBuilder();
            Arrays.stream(OPS.values()).filter(val -> !(val.name().equalsIgnoreCase(OPS.ALL.name()))).forEach(ops -> {
                stringBuilder.append("### " + ops.name()).append(System.lineSeparator()).append(ops.apply(t, u));
            });
            return stringBuilder.toString();
        }

    };

    public static String replaceRepoName(String url, GitRepoResponse gitRepoResponse) {
        return url.replace(API.URL_PLACE_HOLDER_REPO_NAME, gitRepoResponse.getName());
    }

    public static String replaceUserName(String url, GitRepoResponse gitRepoResponse) {
        return url.replace(API.URL_PLACE_HOLDER_USER_NAME, gitRepoResponse.getOwner().getLogin());
    }

    public static String replaceUserNameAndRepoName(String url, GitRepoResponse gitRepoResponse) {
        return replaceRepoName(replaceUserName(url, gitRepoResponse), gitRepoResponse).concat(System.lineSeparator());
    }
}
