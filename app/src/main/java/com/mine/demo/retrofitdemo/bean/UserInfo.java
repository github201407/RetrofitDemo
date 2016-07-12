package com.mine.demo.retrofitdemo.bean;

/**
 * github api user info
 * curl https://api.github.com/users/github201407
 * @author chenmingqun
 * @date 2016/7/12
 */
public class UserInfo {

    /**
     * login : github201407
     * id : 8279310
     * avatar_url : https://avatars.githubusercontent.com/u/8279310?v=3
     * gravatar_id :
     * url : https://api.github.com/users/github201407
     * html_url : https://github.com/github201407
     * followers_url : https://api.github.com/users/github201407/followers
     * following_url : https://api.github.com/users/github201407/following{/other_user}
     * gists_url : https://api.github.com/users/github201407/gists{/gist_id}
     * starred_url : https://api.github.com/users/github201407/starred{/owner}{/repo}
     * subscriptions_url : https://api.github.com/users/github201407/subscriptions
     * organizations_url : https://api.github.com/users/github201407/orgs
     * repos_url : https://api.github.com/users/github201407/repos
     * events_url : https://api.github.com/users/github201407/events{/privacy}
     * received_events_url : https://api.github.com/users/github201407/received_events
     * type : User
     * site_admin : false
     * name : Jen Chen
     * company : null
     * blog : null
     * location : China
     * email : null
     * hireable : null
     * bio : null
     * public_repos : 132
     * public_gists : 0
     * followers : 24
     * following : 117
     * created_at : 2014-07-27T04:19:01Z
     * updated_at : 2016-07-12T08:05:57Z
     */

    public String login;
    public int id;
    public String avatar_url;
    public String gravatar_id;
    public String url;
    public String html_url;
    public String followers_url;
    public String following_url;
    public String gists_url;
    public String starred_url;
    public String subscriptions_url;
    public String organizations_url;
    public String repos_url;
    public String events_url;
    public String received_events_url;
    public String type;
    public boolean site_admin;
    public String name;
    public String company;
    public String blog;
    public String location;
    public String email;
    public String hireable;
    public String bio;
    public int public_repos;
    public int public_gists;
    public int followers;
    public int following;
    public String created_at;
    public String updated_at;

    @Override
    public String toString() {
        return "UserInfo{" +
                "login='" + login + '\'' +
                ", id=" + id +
                ", avatar_url='" + avatar_url + '\'' +
                ", gravatar_id='" + gravatar_id + '\'' +
                ", url='" + url + '\'' +
                ", html_url='" + html_url + '\'' +
                ", followers_url='" + followers_url + '\'' +
                ", following_url='" + following_url + '\'' +
                ", gists_url='" + gists_url + '\'' +
                ", starred_url='" + starred_url + '\'' +
                ", subscriptions_url='" + subscriptions_url + '\'' +
                ", organizations_url='" + organizations_url + '\'' +
                ", repos_url='" + repos_url + '\'' +
                ", events_url='" + events_url + '\'' +
                ", received_events_url='" + received_events_url + '\'' +
                ", type='" + type + '\'' +
                ", site_admin=" + site_admin +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", blog='" + blog + '\'' +
                ", location='" + location + '\'' +
                ", email='" + email + '\'' +
                ", hireable='" + hireable + '\'' +
                ", bio='" + bio + '\'' +
                ", public_repos=" + public_repos +
                ", public_gists=" + public_gists +
                ", followers=" + followers +
                ", following=" + following +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
    }
}
