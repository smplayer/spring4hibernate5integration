var sm = {}
sm.isArray = function(obj) {
	return Object.prototype.toString.call(obj) === '[object Array]';
};
(function($) {
	sm.renderLayout = function(targets) {
		var $targets;
		if (targets) {
			if (!sm.isArray(targets)) {
				targets = [targets];
			}
			$targets = $(targets);
		} else {
			$targets = $(".sm-layout-abs");
		}
		$targets.each(function(i, e) {
			var $e = $(e);
			var $top = $e.find("> .sm-layout-top");
			var $bottom = $e.find("> .sm-layout-bottom");
			/*
			var $left = $e.find("> .sm-layout-left");
			var $right = $e.find("> .sm-layout-right");
			*/
			if ($top.length == 1) {
				$e.css("padding-top", $top.outerHeight() + "px");
			}
			if ($bottom.length == 1) {
				$e.css("padding-bottom", $bottom.outerHeight() + "px");
			}
			/*
			if ($left.length == 1) {
				$e.css("padding-left", $left.outerWidth() + "px");
			}
			if ($right.length == 1) {
				$e.css("padding-right", $right.outerWidth() + "px");
			}
			*/
		});
	};
	sm.renderRatio = function(targets) {
		var $targets;
		if (targets) {
			if (!sm.isArray(targets)) {
				targets = [targets];
			}
			$targets = $(targets);
		} else {
			$targets = $(".sm-js-ratio-square");
		}
		$targets.each(function(i, e) {
			var $e = $(e);
			$e.height($e.width());
		});
	};
	/*	sm.renderGrid = function(targets) {
			var $targets;
			if (targets) {
				if (!sm.isArray(targets)) {
					targets = [targets];
				}
				$targets = $(targets);
			} else {
				$targets = $(".sm-list-grid");
			}
			$targets.each(function(i, e) {
				
			});
		}*/
})(jQuery);
sm.renderLayout();
sm.renderRatio();