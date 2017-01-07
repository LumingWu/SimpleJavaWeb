drop schema simpleweb;
create schema simpleweb;
use simpleweb;

create table user(
    userid integer auto_increment,
    firstname char(20) not null,
    lastname char(20) not null,
    middlename char(20) not null,
    nickname char(30) not null unique,
    password char(30) not null,
    primary key (userid)
);

create table friend(
    userid1 integer not null,
    userid2 integer not null,
    check(userid1 <> userid2),
    primary key (userid1, userid2),
    foreign key (userid1) references user (userid)
    on delete cascade
    on update no action,
    foreign key (userid2) references user (userid)
    on delete cascade
    on update no action
);

create table email(
    userid integer not null,
    email char(40) not null unique,
    primary key (userid, email),
    foreign key (userid) references user (userid)
    on delete cascade
    on update no action
);

create table post(
    postid bigint auto_increment,
    userid integer not null,
    content varchar(50) not null,
    `time` datetime not null,
    primary key (postid),
    foreign key (userid) references user (userid)
    on delete cascade
    on update no action
);

create table reply(
    postid1 bigint not null,
    postid2 bigint not null,
    check(postid1 <> postid2),
    primary key (postid1, postid2),
    foreign key (postid1) references post (postid)
    on delete cascade
    on update no action,
    foreign key (postid2) references post (postid)
    on delete cascade
    on update no action
);

create table likes(
    postid bigint not null unique,
    likes integer not null,
    primary key (postid, likes),
    foreign key (postid) references post (postid)
    on delete cascade
    on update no action
);